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
package verifyinganaliendictionary;

public class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    for (int i = 0; i < words.length - 1; ++i) {
      if (!isGreaterThan(words[i], words[i + 1], order)) {
        return false;
      }
    }
    return true;
  }

  boolean isGreaterThan(String w1, String w2, String order) {
    for (int i = 0; i < w1.length() && i < w2.length(); ++i) {
      if (w1.charAt(i) == w2.charAt(i)) {
        continue;
      }
      return order.indexOf(w1.charAt(i)) < order.indexOf(w2.charAt(i));
    }
    return w1.length() <= w2.length();
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution().isAlienSorted(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
  }
}
