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
package coinchange2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  Map<String, Long> countCache = new HashMap<>();

  public int change(int amount, int[] coins) {
    if (amount == 0) {
      return 1;
    }
    long count = 0;
    for (int i = coins.length - 1; i >= 0; --i) {
      if (coins[i] <= amount) {
        count += change(amount - coins[i], coins, i);
      }
    }

    return (int) count;
  }

  private long change(int amount, int[] coins, int index) {
    if (amount == 0) {
      return 1;
    }
    String key = String.valueOf(amount) + '#' + index;
    if (countCache.containsKey(key)) {
      return countCache.get(key);
    }
    long count = 0;
    for (int i = index; i >= 0; --i) {
      if (coins[i] <= amount) {
        count += change(amount - coins[i], coins, i);
      }
    }
    countCache.put(key, count);

    return count;
  }
}
