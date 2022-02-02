/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package largesttrianglearea;

public class Solution {
  public double largestTriangleArea(int[][] points) {
    double largestArea = 0.0d;
    for (int i = 0; i < points.length; ++i) {
      for (int j = i + 1; j < points.length; ++j) {
        for (int k = j + 1; k < points.length; ++k) {
          double area = getArea(points[i], points[j], points[k]);
          if (!Double.isNaN(area) && area > largestArea) {
            largestArea = area;
          }
        }
      }
    }
    return largestArea;
  }

  double getArea(int[] p1, int[] p2, int[] p3) {
    double a = getLength(p1, p2);
    double b = getLength(p2, p3);
    double c = getLength(p1, p3);
    double p = 0.5 * (a + b + c);
    double pa = p - a;
    double pb = p - b;
    double pc = p - c;
    return Math.sqrt(p * pc * pb * pa);
  }

  double getLength(int[] p1, int[] p2) {
    double abs1 = Math.abs(p1[0] - p2[0]);
    double abs2 = Math.abs(p1[1] - p2[1]);
    return Math.sqrt(abs1 * abs1 + abs2 * abs2);
  }

  public static void main(String[] args) {
    System.out.println(new Solution().largestTriangleArea(new int[][] {{-2, -5}, {9, 7}, {2, -2}}));
  }
}
