package by.borisevich.phone.book.tool;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
public class Test
{
    public static void main ( String [] args )
    {
        A a = new A ();

        // initialize composition
        Composition c = new Composition ();
        c.setTestable ( a );

        // test of composition class
        System.out.println ("---------------------") ;
        System.out.println ("testing composition: ") ;
        c.getTestable ().test ();
        /* ^^ we know composition class have testable,
         * so we are using it to perform some actions
         * Example: System.out.println();  out is an nested field, and is example of composition
         */

        // adjust behavior using different delegations
        DelegationA d1 = new DelegationA ( a );
        DelegationB d2 = new DelegationB ( a );
        DelegationA d3 = new DelegationA ( d1 );
        DelegationA d4 = new DelegationA ( d2 );

        // test of delegation
        System.out.println ("---------------------") ;
        System.out.println ("testing delegation: ") ;
        ITestable [] arr = new ITestable[] {a, d1, d2, d3, d4};
        for ( ITestable t : arr )
        {
            t.test ();
            System.out.println ("\n") ;
        }
    }
}
