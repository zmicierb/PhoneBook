package by.borisevich.phone.book.tool;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
class DelegationB implements ITestable
{
    private ITestable testable ;

    public DelegationB ( ITestable testable )
    {
        this.testable = testable ;
    }

    public void test ()
    {
        System.out.println ( "before test" ) ;
        testable.test () ;
        System.out.println ( "after test" ) ;
    }
}
