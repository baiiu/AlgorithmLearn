#include <stdio.h>

struct MyPoint{
  float x;
  float y;
};
typedef struct MyPoint Point;


int main()
{

  Point p;
  p.x = 1.0;
  p.y = 1.0;

  printf("%f\n", p.x);
  printf("%f\n", p.y);


   /* 我的第一个 C 程序 */
   printf("Hello, World! \n");

   return 0;
}
