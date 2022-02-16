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
package pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
  char EMPTY = '\u0000';
  char PACIFIC = 'p';
  char ATLANTIC = 'a';
  char BOTH = 'b';

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int height = heights.length;
    int width = heights[0].length;
    // p means flow to pacific
    // a means flow to atlantic
    // b means flow to both
    char[][] flowMap = new char[height][width];
    for (int i = 0; i < height; ++i) {
      set(flowMap, i, 0, PACIFIC);
      set(flowMap, i, width - 1, ATLANTIC);
    }
    for (int j = 0; j < width; ++j) {
      set(flowMap, 0, j, PACIFIC);
      set(flowMap, height - 1, j, ATLANTIC);
    }

    boolean change = true;
    while (change) {
      change = false;
      for (int i = 0; i < height; ++i) {
        for (int j = 0; j < width; ++j) {
          // flow upper
          if (i - 1 >= 0
              && heights[i][j] >= heights[i - 1][j]
              && flowMap[i][j] != BOTH
              && flowMap[i][j] != flowMap[i - 1][j]
              && flowMap[i - 1][j] != EMPTY) {
            set(flowMap, i, j, flowMap[i - 1][j]);
            change = true;
          }

          // flow down
          if (i + 1 < height
              && heights[i][j] >= heights[i + 1][j]
              && flowMap[i][j] != BOTH
              && flowMap[i][j] != flowMap[i + 1][j]
              && flowMap[i + 1][j] != EMPTY) {
            set(flowMap, i, j, flowMap[i + 1][j]);
            change = true;
          }

          // flow left
          if (j - 1 >= 0
              && heights[i][j] >= heights[i][j - 1]
              && flowMap[i][j] != BOTH
              && flowMap[i][j] != flowMap[i][j - 1]
              && flowMap[i][j - 1] != EMPTY) {
            set(flowMap, i, j, flowMap[i][j - 1]);
            change = true;
          }

          // flow right
          if (j + 1 < width
              && heights[i][j] >= heights[i][j + 1]
              && flowMap[i][j] != BOTH
              && flowMap[i][j] != flowMap[i][j + 1]
              && flowMap[i][j + 1] != EMPTY) {
            set(flowMap, i, j, flowMap[i][j + 1]);
            change = true;
          }
        }
      }
    }

    List<List<Integer>> resultList = new LinkedList<>();
    for (int i = 0; i < height; ++i) {
      for (int j = 0; j < width; ++j) {
        if (flowMap[i][j] == BOTH) {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          list.add(j);
          resultList.add(list);
        }
      }
    }
    return resultList;
  }

  private void set(char[][] flowMap, int i, int j, char DIR) {
    if (flowMap[i][j] == EMPTY) {
      flowMap[i][j] = DIR;
    } else if (flowMap[i][j] != DIR) {
      flowMap[i][j] = BOTH;
    }
  }
}
