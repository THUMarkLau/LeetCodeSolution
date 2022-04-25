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
package removeoutermostparentheses;

public class Solution {
  public String removeOuterParentheses(String s) {
    int leftCnt = 0;
    StringBuilder builder = new StringBuilder(s.length() - 2);
    char[] chars = s.toCharArray();
    int length = s.length();

    for (int i = 0; i < length; ++i) {
      char c = chars[i];
      if (c == '(') {
        if (leftCnt != 0) {
          builder.append('(');
        }
        leftCnt++;
      } else {
        leftCnt--;
        if (leftCnt != 0) {
          builder.append(')');
        }
      }
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().removeOuterParentheses("(())()"));
  }
}
