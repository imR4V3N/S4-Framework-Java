package mg.itu.framework.sprint.controller;

// import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import mg.itu.framework.sprint.utils.Utils;

public class FrontController  extends HttpServlet{
    private ArrayList<Class<?>> classController;
    private boolean checked = false;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void initValue() {
        try {
            String packageCtrl = this.getInitParameter("packageName");
            this.setClassController(Utils.getControllerClasses(packageCtrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Class<?>> getClassController() {
        return classController;
    }
    public void setClassController(ArrayList<Class<?>> classController) {
        this.classController = classController;
    }

    public void showController(PrintWriter out) throws IOException{
        ArrayList<Class<?>> classes = new ArrayList<>();
        if (classes != null) {
            classes = this.getClassController();

            out.println("Controllers : ");
            for (Class<?> classe : classes) {
                out.println("- " + classe.getSimpleName());
            }
        }
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        out.println("URL : " + request.getRequestURI());
        if (!isChecked()) {
            this.initValue();
            this.setChecked(true);
        }
        this.showController(out);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        this.processRequest(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        this.processRequest(request,response);
    }
}