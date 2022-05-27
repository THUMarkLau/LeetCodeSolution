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
package allelementsintwobstree;

import commons.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> resultList = new LinkedList<>();
    LinkedList<Integer> listFromTree1 = new LinkedList<>();
    LinkedList<Integer> listFromTree2 = new LinkedList<>();
    getElementsFromOneTree(root1, listFromTree1);
    getElementsFromOneTree(root2, listFromTree2);
    while (!listFromTree1.isEmpty() && !listFromTree2.isEmpty()) {
      if (listFromTree1.getFirst() < listFromTree2.getFirst()) {
        resultList.add(listFromTree1.removeFirst());
      } else {
        resultList.add(listFromTree2.removeFirst());
      }
    }

    if (!listFromTree1.isEmpty()) {
      resultList.addAll(listFromTree1);
    }

    if (!listFromTree2.isEmpty()) {
      resultList.addAll(listFromTree2);
    }

    return resultList;
  }

  private void getElementsFromOneTree(TreeNode root, List<Integer> numList) {
    if (root == null) {
      return;
    }
    getElementsFromOneTree(root.left, numList);
    numList.add(root.val);
    getElementsFromOneTree(root.right, numList);
  }
}
