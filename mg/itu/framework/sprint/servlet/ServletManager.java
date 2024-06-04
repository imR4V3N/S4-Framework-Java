package mg.itu.framework.sprint.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import mg.itu.framework.sprint.annotation.Controller;
import mg.itu.framework.sprint.annotation.Get;
import mg.itu.framework.sprint.utils.Utils;
import mg.itu.framework.sprint.utils.Mapping;


public class ServletManager {
    public static ArrayList<Class<?>> getControllerClasses(String packageName) throws ClassNotFoundException, IOException {
        ArrayList<Class<?>> classes = Utils.getClasses(packageName);
        ArrayList<Class<?>> result = new ArrayList<Class<?>>();
        
        for(Class<?> classe : classes) {
            if (classe.isAnnotationPresent(Controller.class)) {
                result.add(classe);
            }
        }

        return result;
    }

    public static HashMap<String,Mapping> getControllerMethod(ArrayList<Class<?>> classes) throws Exception {
        HashMap<String,Mapping> result = new HashMap<>();
        if (classes != null) {
            for(Class<?> classe : classes) {
                ArrayList<Method> methods = Utils.getListMethod(classe);
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Get.class)) {
                        String url = ((Get) method.getAnnotation(Get.class)).value();
                        if (result.get(url)==null) {
                            Mapping mapping = new Mapping(classe.getSimpleName(),method.getName());
                            result.put(url, mapping);
                        } else {
                            // throw new Exception("Duplicate annotation : "+ url +" in multiple methods!");
                            return null;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static Mapping getUrl(HashMap<String, Mapping> maps, String url) {
        Mapping result = null;
        String[] path = url.split("/");
        String newUrl = new String();
        int lenght = path.length-1;
        for (int i = lenght; i >= 0; i--) {
            if (i < lenght) {
                newUrl = "/" + newUrl;
            }
            newUrl = path[i] + newUrl;
            Mapping map = maps.get(newUrl);
            
            if (map != null) {
                result = map;
            }
        }
        return result;
    }
}
