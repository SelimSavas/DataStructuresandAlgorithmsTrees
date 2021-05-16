package grup12odev2;

class soru4    				// Ana class'ýmýz
{
  
static class Node           // Düðüm mantýðýný oluþturma  // O(1)
{
 int data;     							// Ýkili aðaç düðümümüzdeki verileri tanýmlama
 Node left;    							// Sol çocuktaki pointer-iþaretçi
 Node right;   							// Sað çocuktaki pointer-iþaretçi
};


static Node newNode(int data)  	// yeni bir düðüm ayýran yardýmcý iþlev  // O(1)
{
 Node node = new Node();  			// node class'ýnýn verileriyle new Node
 node.data = data;        			// data tanýmlama
 node.left = null;        			// boþ sol çocuk pointer tanýmlama
 node.right = null;       			// boþ sað çocuk pointer tanýmlama
 return(node);            			// node deðerini döndür.
 
}

//Ýki aðacýn ayný yapýya
//sahip olup olmadýðýný kontrol eden iþlev:
static boolean ayniYapi(Node a, Node b)  // O(n!)
{
 // 1. ikisi de boþsa:
 if (a == null && b == null)
     return true;

 // 2. ikisi de boþ deðilse: onlarý karþýlaþtýr.
 if (a != null && b != null)
 {
     return
     (
         ayniYapi(a.left, b.left) &&
         ayniYapi(a.right, b.right)
     );
 }
  
 // 3. sadece biri boþsa: false
 return false;
}

//Aðacýmýzýn verilerini atadýðýmýz main çalýþma kodumuz:
public static void main(String args[])   // O(1)
{
 Node root1 = newNode(10);      // kök 10 
 Node root2 = newNode(100);     // kök 100
 
 // kök 1'e eklenen düðümler
 root1.left = newNode(7);
 root1.right = newNode(15);
 root1.left.left = newNode(4);
 root1.left.right = newNode(9);
 // root1.right.right = newNode(20);

 
 // kök 2'e eklenen düðümler
 root2.left = newNode(70);
 root2.right = newNode(150);
 root2.left.left = newNode(40);
 root2.left.right = newNode(90);
 root2.right.right = newNode(200);
 
 
 // kök karþýlaþtýrma iþlemi
 if (ayniYapi(root1, root2))
     System.out.printf("Her iki aðaç da ayný yapýya sahip!");
 else
     System.out.printf("Aðaçlar ayný yapýya sahip deðil!");
}
}

