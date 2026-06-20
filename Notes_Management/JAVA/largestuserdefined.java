import.java.util.Scanner;
public class Largest
public static void main(string[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a:");
int a= sc.nextInt();
System.out.println("Enter b:");
int b= sc.nextInt();
System.out.println("Enter c:");
int c= sc.nextInt();

if(a>b&a>c)
System.out.println("a largest");
if(b>a&b>c)
System.out.println("b largest");
else
System.out.println("c largest");
sc.close();
}