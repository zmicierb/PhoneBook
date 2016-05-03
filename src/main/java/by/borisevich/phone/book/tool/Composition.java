package by.borisevich.phone.book.tool;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
class Composition
{
    private ITestable testable ;

    public ITestable getTestable ()
    {
        return testable ;
    }

    public void setTestable ( ITestable testable )
    {
        this.testable = testable ;
    }
}
