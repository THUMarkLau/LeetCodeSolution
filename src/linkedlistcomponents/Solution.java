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
package linkedlistcomponents;

public class Solution {
  public int numComponents(ListNode head, int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int j : nums) {
      if (j > max) {
        max = j;
      }
    }
    boolean[] containFlags = new boolean[max + 1];
    for (int num : nums) {
      containFlags[num] = true;
    }
    int componentsNum = 0;
    boolean newComponent = true;
    ListNode curr = head;
    while (curr != null) {
      int val = curr.val;
      if (val <= max && containFlags[val]) {
        if (newComponent) {
          componentsNum++;
          newComponent = false;
        }
      } else {
        newComponent = true;
      }
      curr = curr.next;
    }
    return componentsNum;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(0);
    ListNode curr = head;
    for (int i = 1; i < 3; ++i) {
      curr.next = new ListNode(i);
      curr = curr.next;
    }

    System.out.println(new Solution().numComponents(head, new int[] {0, 2}));
  }
}
