package by.borisevich.phone.book.tool;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
class DelegationA implements ITestable
{
    private ITestable testable ;

    public DelegationA ( ITestable testable )
    {
        this.testable = testable ;
    }

    public void test ()
    {
        System.out.println ( "delegating test to: " + testable.getClass () ) ;
        testable.test () ;
    }
}
