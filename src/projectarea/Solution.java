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
package projectarea;

public class Solution {
  public int projectionArea(int[][] grid) {
    int areaFromUpper = 0;
    int areaFromFront = 0;
    int areaFromLeft = 0;
    int[] maxInEachDim = new int[grid.length];
    int[] maxInEachArray = new int[grid[0].length];
    for (int i = 0; i < grid.length; ++i) {
      maxInEachArray[i] = 0;
      for (int j = 0; j < grid[i].length; ++j) {
        if (grid[i][j] != 0) {
          areaFromUpper++;
        }
        if (grid[i][j] > maxInEachArray[i]) {
          maxInEachArray[i] = grid[i][j];
        }
        if (grid[i][j] > maxInEachDim[j]) {
          maxInEachDim[j] = grid[i][j];
        }
      }
    }
    for (int maxInDim : maxInEachDim) {
      areaFromFront += maxInDim;
    }
    for (int maxInArray : maxInEachArray) {
      areaFromLeft += maxInArray;
    }

    return areaFromUpper + areaFromFront + areaFromLeft;
  }
}
