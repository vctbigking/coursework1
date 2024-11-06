int[] average_grades(int grades[][], int weights[]) {  
     int[] averageGrades = new int[grades.length];  
     for (int i = 0; i < grades.length; i++) {  
         int weightedSum = 0;  
         for (int j = 0; j < grades[i].length; j++) {  
             weightedSum += grades[i][j] * weights[j];  
         }  
         averageGrades[i] = weightedSum / 100;  
     }  
     return averageGrades;  
 }
