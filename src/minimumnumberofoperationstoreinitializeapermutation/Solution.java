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
package minimumnumberofoperationstoreinitializeapermutation;

public class Solution {
  public int reinitializePermutation(int n) {
    int[] arr = new int[n];
    int[] perm = new int[n];
    int[] oriPerm = new int[n];
    for (int i = 0; i < n; ++i) {
      perm[i] = i;
      oriPerm[i] = i;
    }

    int cnt = 0;
    while (true) {
      cnt++;
      for (int i = 1; i < n; i += 2) {
        arr[i] = perm[n / 2 + (i - 1) / 2];
      }
      for (int i = 0; i < n; i += 2) {
        arr[i] = perm[i / 2];
      }
      if (isSame(arr, oriPerm)) {
        return cnt;
      }
      //      int[] tmp = perm;
      //      perm = arr;
      //      arr = tmp;
      perm = arr;
      arr = new int[n];
    }
  }

  boolean isSame(int[] x, int[] y) {
    for (int i = 0; i < x.length; ++i) {
      if (x[i] != y[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().reinitializePermutation(6));
  }
}
