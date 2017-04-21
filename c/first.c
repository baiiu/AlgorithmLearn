#include <stdio.h>

// struct MyPoint{
//   float x;
//   float y;
// };
// typedef struct MyPoint Point;

// 定义类型时起别名
typedef struct{
  float x;
  float y;
}Point;

typedef Point *SP;




int main()
{

  Point p;
  p.x = 1.0;
  p.y = 1.0;

  printf("%f\n", p.x);
  printf("%f\n", p.y);

  printf("Hello, World! \n");

  SP pp = &p;
  printf("%f\n", pp->x);
  printf("%f\n", pp->y);


   /* 我的第一个 C 程序 */

   return 0;
}
