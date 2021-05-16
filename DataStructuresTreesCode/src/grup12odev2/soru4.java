package grup12odev2;

class soru4    				// Ana class'�m�z
{
  
static class Node           // D���m mant���n� olu�turma  // O(1)
{
 int data;     							// �kili a�a� d���m�m�zdeki verileri tan�mlama
 Node left;    							// Sol �ocuktaki pointer-i�aret�i
 Node right;   							// Sa� �ocuktaki pointer-i�aret�i
};


static Node newNode(int data)  	// yeni bir d���m ay�ran yard�mc� i�lev  // O(1)
{
 Node node = new Node();  			// node class'�n�n verileriyle new Node
 node.data = data;        			// data tan�mlama
 node.left = null;        			// bo� sol �ocuk pointer tan�mlama
 node.right = null;       			// bo� sa� �ocuk pointer tan�mlama
 return(node);            			// node de�erini d�nd�r.
 
}

//�ki a�ac�n ayn� yap�ya
//sahip olup olmad���n� kontrol eden i�lev:
static boolean ayniYapi(Node a, Node b)  // O(n!)
{
 // 1. ikisi de bo�sa:
 if (a == null && b == null)
     return true;

 // 2. ikisi de bo� de�ilse: onlar� kar��la�t�r.
 if (a != null && b != null)
 {
     return
     (
         ayniYapi(a.left, b.left) &&
         ayniYapi(a.right, b.right)
     );
 }
  
 // 3. sadece biri bo�sa: false
 return false;
}

//A�ac�m�z�n verilerini atad���m�z main �al��ma kodumuz:
public static void main(String args[])   // O(1)
{
 Node root1 = newNode(10);      // k�k 10 
 Node root2 = newNode(100);     // k�k 100
 
 // k�k 1'e eklenen d���mler
 root1.left = newNode(7);
 root1.right = newNode(15);
 root1.left.left = newNode(4);
 root1.left.right = newNode(9);
 // root1.right.right = newNode(20);

 
 // k�k 2'e eklenen d���mler
 root2.left = newNode(70);
 root2.right = newNode(150);
 root2.left.left = newNode(40);
 root2.left.right = newNode(90);
 root2.right.right = newNode(200);
 
 
 // k�k kar��la�t�rma i�lemi
 if (ayniYapi(root1, root2))
     System.out.printf("Her iki a�a� da ayn� yap�ya sahip!");
 else
     System.out.printf("A�a�lar ayn� yap�ya sahip de�il!");
}
}

