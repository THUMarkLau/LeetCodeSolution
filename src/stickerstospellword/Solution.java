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
package stickerstospellword;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  Map<String, Integer> cache = new HashMap<>();

  public int minStickers(String[] stickers, String target) {
    int minTry = Integer.MAX_VALUE;
    if (target.equals("")) {
      return 0;
    }
    if (cache.containsKey(target)) {
      return cache.get(target);
    }
    for (String sticker : stickers) {
      int same = 0;
      boolean[] tempMask = new boolean[target.length()];
      for (char c : sticker.toCharArray()) {
        for (int i = 0; i < target.length(); ++i) {
          if (target.charAt(i) == c && !tempMask[i]) {
            same++;
            tempMask[i] = true;
            break;
          }
        }
      }
      StringBuilder subBuilder = new StringBuilder();
      for (int i = 0; i < target.length(); ++i) {
        if (!tempMask[i]) {
          subBuilder.append(target.charAt(i));
        }
      }

      if (same == 0) {
        continue;
      }
      int subStrRes = minStickers(stickers, subBuilder.toString());
      if (subStrRes == -1) {
        cache.put(subBuilder.toString(), -1);
      } else {
        cache.put(subBuilder.toString(), subStrRes);
        if (minTry > subStrRes + 1) {
          minTry = subStrRes + 1;
        }
      }
    }
    return minTry == Integer.MAX_VALUE ? -1 : minTry;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution()
            .minStickers(new String[] {"these", "guess", "about", "garden", "him"}, "atomher"));
  }
}
