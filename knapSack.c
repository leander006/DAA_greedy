#include<stdio.h>

void knapsack (int n, float weight[], float profit[], float capacity, int index[])
{
  float x[20], tp = 0;
  int i, u;
  u = capacity;
  for (i = 0; i < n; i++)
    x[i] = 0.0;
  for (i = 0; i < n; i++)
    {
      if (weight[i] > u)
	break;
      else
	{
	  x[index[i]] = 1.0;
	  tp = tp + profit[i];
	  u = u - weight[i];
	}
    }

  if (i < n)
    x[index[i]] = u / weight[i];


  tp = tp + (x[index[i]] * profit[i]);

  printf ("\nThe result vector is:- ");
  for (i = 0; i < n; i++)
    printf ("%f\t", x[i]);
  printf ("\nMaximum profit is:- %f", tp);
}

int main ()
{
  float weight[20], profit[20], capacity;
  int num, i, j, index[20];
  float ratio[20], temp;
  printf ("\nEnter the no. of objects:- ");
  scanf ("%d", &num);
  printf ("\nEnter the profits and wts of each object:- ");
  for (i = 0; i < num; i++)
    {
      scanf ("%f %f", &profit[i], &weight[i]);
      index[i] = i;
    }

  printf ("\nEnter the capacity of knapsack:- ");
  scanf ("%f", &capacity);

  for (i = 0; i < num; i++)
    {
      ratio[i] = profit[i] / weight[i];
    }


  for (i = 0; i < num; i++)
    {
      for (j = i + 1; j < num; j++)
	{
	  if (ratio[i] < ratio[j])
	    {
	      temp = ratio[j];
	      ratio[j] = ratio[i];
	      ratio[i] = temp;

	      temp = index[j];
	      index[j] = index[i];
	      index[i] = temp;
	      
	      temp = weight[j];
	      weight[j] = weight[i];
	      weight[i] = temp;

	      temp = profit[j];
	      profit[j] = profit[i];
	      profit[i] = temp;



	    }
	}
    }
  knapsack (num, weight, profit, capacity, index);
  return (0);
}