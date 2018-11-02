import java.util.*;

class Building{}

class House extends Building{}

class ClassTypeCapture<T>{

    Class<T> kind;
    Map<String, Class<?>> map;

    public ClassTypeCapture(Class<T> kind){
        this.kind = kind;
        map = new HashMap<>();
    }

    public void addType(String typename, Class<?> kind){

        map.put(typename, kind);
    }

    public void createNew(String typeName) throws InstantiationException, IllegalAccessException{
        Class<?> a = map.get(typeName);
        System.out.println(a.getName());
        Object newInstance = a.newInstance();
        
        //System.out.println(newInstance.getClass());
    }

    public boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        
        ClassTypeCapture<Building> c1 = new ClassTypeCapture<Building>(Building.class);

        c1.addType("String", String.class);
        c1.addType("Integer", Integer.class);

        try{
        c1.createNew("String");

        }
        catch(Exception e){
            System.out.println(e);
        }        
        
        System.out.println(c1.f(new Building()));


    }

}