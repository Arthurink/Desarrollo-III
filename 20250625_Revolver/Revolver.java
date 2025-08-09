import java.util.*;

public class Revolver
{

    int[] vnum = {15, 30, 25, 10, 20};
    Random rnd = new Random();

    public static void main(String[] args)
    {
        new Revolver();
    }

    Revolver()
    {

        System.out.println("Original");
        int i;
        for (i=0;i<5;i++)
            System.out.println(vnum[i]);

        System.out.println("Ordenado");
        int j, tmp=0;
        for (i=0;i<5-1;i++)
            for (j=i+1;j<5;j++)
                if (vnum[i] > vnum[j])
                {
                    tmp = vnum[i];
                    vnum[i] = vnum[j];
                    vnum[j] = tmp;
                }

        for (i=0;i<5;i++)
            System.out.println(vnum[i]);

        System.out.println("Revolver");
        for (i=0;i<5;i++)
        {
           j = rnd.nextInt(5);
           tmp = vnum[i];
           vnum[i] = vnum[j];
           vnum[j] = tmp;
        }
        
        for (i=0;i<5;i++)
            System.out.println(vnum[i]);


    }
}








