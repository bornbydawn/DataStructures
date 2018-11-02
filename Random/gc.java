public class gc 
{ 
	public static void main(String [] args) 
	{ 
        gc t1 = new gc(); 
        System.out.println(t1.hashCode());
        gc t2 = m1(t1); // line 6 
        System.out.println(t2.hashCode());      
        System.out.println(t1.hashCode());        
		gc t3 = new gc(); 
		t2 = t3; // line 8 
        
        System.gc();
	} 
	
	static gc m1(gc temp) 
	{ 
		temp = new gc();
		return temp; 
	}
	
	@Override
    protected void finalize()  
    {  
       // System.out.println(this.hashcode); 
        System.out.println("finalize method called");   
    } 
} 
