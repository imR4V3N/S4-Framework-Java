package mg.itu.framework.sprint.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mg.itu.framework.sprint.utils.Mapping;
import mg.itu.framework.sprint.servlet.ServletManager;
import mg.itu.framework.sprint.servlet.ModelView;
import mg.itu.framework.sprint.utils.Utils;

@SuppressWarnings("deprecation")
public class FrontController  extends HttpServlet{
    private ArrayList<Class<?>> classController = new ArrayList<>();
    private HashMap<String,Mapping> controllerAndMethod = new HashMap<>(); 

    public ArrayList<Class<?>> getClassController() {
        return classController;
    }
    public void setClassController(ArrayList<Class<?>> classController) {
        this.classController = classController;
    }
    public HashMap<String, Mapping> getControllerAndMethod() {
        return controllerAndMethod;
    }
    public void setControllerAndMethod(HashMap<String, Mapping> controllerAndMethod) {
        this.controllerAndMethod = controllerAndMethod;
    }
    public void addControllerAndMethod(String url, Mapping method) {
        this.controllerAndMethod.put(url, method);
    }

    public void initController() {
        try {
            String packageCtrl = this.getInitParameter("packageName");
            this.setClassController(ServletManager.getControllerClasses(packageCtrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() throws ServletException{
        String packageCtrl = this.getInitParameter("packageName");
        this.initController();
        try {
            HashMap<String,Mapping> map = ServletManager.getControllerMethod(this.getClassController());
            
            if (map != null) {
                this.setControllerAndMethod(map);
            }
            if (map == null) {
                throw new Exception("Duplicate annotation in multiple methods!");
            }
            if (this.getClassController().size() == 0) {   
                throw new Exception("The package " + packageCtrl + " is empty or doesn't exist!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showController(PrintWriter out) {
        ArrayList<Class<?>> classes = new ArrayList<>();
        if (classes != null && this.getClassController() != null && !this.getClassController().isEmpty()) {
            classes = this.getClassController();

            out.println("Controllers : ");
            for (Class<?> classe : classes) {
                out.println("- " + classe.getSimpleName());
            }
        }
    }

    public void showControllerAndMethod(PrintWriter out, String url){
        Mapping map = ServletManager.getUrl(this.getControllerAndMethod(), url);
        try {
            if (map != null) {
                out.println("Controller Name : " + map.getClassName());
                out.println("Method Name : " + map.getMethodName());
            } else {
                throw new Exception("Error 404 not found!");
            }
        } catch (Exception e) {
            out.println("Error : " + e.getMessage());
        }
    }

    public void dispatchModelView(ModelView modelView, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Map.Entry<String,Object> data : modelView.getData().entrySet()){
            String varName = data.getKey();
            Object varValue = data.getValue();
            request.setAttribute(varName,varValue);
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/"+modelView.getUrl());
        dispatcher.forward(request,response);
    }

    public void executeMethodController(String url, HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {
        PrintWriter out = response.getWriter();
        
        String packageCtrl = this.getInitParameter("packageName");
        Mapping map = ServletManager.getUrl(this.getControllerAndMethod(), url);

        try {
            if (map != null) {
                String className = map.getClassName();
                String methodName = map.getMethodName();
                String classPath = packageCtrl+"."+className;
                
                Class<?> controllerClass = Class.forName(classPath);
                Method controllerMethod = Utils.getMethod(controllerClass, methodName);

                if (controllerMethod.getReturnType() == String.class || controllerMethod.getReturnType() == ModelView.class) {
                    Object ctrlObj = controllerClass.newInstance(); 
                    
                    if (controllerMethod.getReturnType() == String.class) {
                        String methodReturn =  (String) Utils.executeSimpleMethod(ctrlObj, methodName);
                    
                        out.print("After executing the "+ methodName +" method in the "+ className +".class, this method returned the value: ");
                        out.println(methodReturn);
                    } 
                    if (controllerMethod.getReturnType() == ModelView.class) {
                        ModelView modelView = (ModelView) Utils.executeSimpleMethod(ctrlObj, methodName);
                        this.dispatchModelView(modelView, request, response);
                    }
                } else {
                    throw new Exception("The return type of method "+ methodName + " in " + className + ".class is invalid!" );
                }
            } else {
                throw new Exception("Error 404 not found!");
            }
        } catch (Exception e) {
            out.println("Error : " + e.getMessage());
        }
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        String url =  request.getRequestURI();
        out.println("URL : " + url);
        this.executeMethodController(url, request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        this.processRequest(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        this.processRequest(request,response);
    }
}