
package test;

   public class Sample { 
	   public void hello(String name)  {
		    if (name == null) {
		    throw new SampleException();
		    }
		    if ("".equals(name)) {
		    throw new TestException();
		    }
		    // do something



	 }

 }
