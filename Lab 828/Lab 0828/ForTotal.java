//� A+ Computer Science
// www.apluscompsci.com

//for loop used to total up values

import static java.lang.System.*;

public class ForTotal
{
    public static void main()
    { int total = 0;
        for(int i = 1; i < 6; i++)
        {
            total = total + i;
        }
        out.print("total " + total);
    }

}
