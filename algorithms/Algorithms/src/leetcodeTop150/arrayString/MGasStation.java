package leetcodeTop150.arrayString;

public class MGasStation {
    /*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.



Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at index 3: tank = 4 - 1 = 3
Start at index 4: tank = 3 + 5 = 8
Travel to index 0. Your tank = 8 - 2 + 1 = 7
Travel to index 1. Your tank = 7 - 3 + 2 = 6
Travel to index 2. Your tank = 6 - 4 + 3 = 5
Travel to index 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1

    Constraints:
n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 104
     */

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int[] gas1 = {2,3,4};
        int[] cost1 = {3,4,3};
                int[] gas2 = {3,1,1};
        int[] cost2 = {1,2,2};
int[] gas3 = {4,5,3,1,4};
int[] cost3 = {5,4,3,4,2};
        System.out.println(canCompleteCircuit(gas,cost));//exp.out.: 3
        System.out.println(canCompleteCircuit(gas1,cost1));//exp.out.: -1
        System.out.println(canCompleteCircuit(gas2,cost2));//exp.out.: 0
        System.out.println(canCompleteCircuit(gas3,cost3));//exp.out.: -1
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
            int canComplete = -1;
            int startI = 0;
            int iterations = 0;
            int i = startI;
            int gasLvl = 0;

            while (startI < cost.length) {
                if (i > cost.length - 1) {
                    i = i - cost.length;
                }
                if (i == startI && iterations > 0) {
                    canComplete = startI;
                    return canComplete;
                }
                gasLvl += gas[i] - cost[i];
                if (gasLvl < 0) {
                    if (iterations==cost.length&&gasLvl==0){return startI;}
                        startI++;
                        i = startI;
                        gasLvl = 0;
                        iterations = 0;
                } else {
                    iterations++;
                    i++;
                }
            }
            return canComplete;
        }
    }

