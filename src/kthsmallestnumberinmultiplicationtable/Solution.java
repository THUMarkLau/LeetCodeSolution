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
package kthsmallestnumberinmultiplicationtable;

public class Solution {
  public int findKthNumber(int m, int n, int k) {
    int left = 1, right = m * n;
    int mid = 0;
    while (left < right) {
      mid = left + (right - left) / 2;
      int cnt = count(m, n, mid);
      if (cnt >= k) {
        // more than k nums is smaller
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  int count(int m, int n, int val) {
    int cnt = 0;
    for (int i = 1; i <= m; ++i) {
      cnt += Math.min(n, val / i);
    }
    return cnt;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findKthNumber(3, 3, 4));
  }
}
