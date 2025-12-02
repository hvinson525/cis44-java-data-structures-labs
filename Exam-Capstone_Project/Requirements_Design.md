# Capstone Project - Job Scheduler Design Document

## Problem Analysis
I need to create a system to schedule jobs based on priority. Jobs with a higher priority should be executed first.

Choice of Data Structure
I will use a priority queue implemented with a max-heap and assign more important jobs a higher number.

## UML Diagram
+---------------------+
|    JobScheduler     |
+---------------------+
| - heap: Heap<Job>   |
+---------------------+
| + addJob(job: Job)  |
| + removeJob(): Job  |
| + peekJob(): Job    |
+---------------------+

          ^
          |
          | uses
          v

+---------------------+
|        Heap<T>      |
+---------------------+
| - data: List<T>     |
+---------------------+
| + insert(item: T)   |
| + extractRoot(): T  |
| + peek(): T         |
| + upHeap(index)     |
| + downHeap(index)   |
+---------------------+

+---------------------+
|         Job         |
+---------------------+
| - id: int           |
| - priority: int     |
| - description: str  |
+---------------------+

## Big-O Justification
- Insert: O(log n)
- Remove highest priority: O(log n)
- Peek: O(1)
- Heap construction (bulk): O(n)
- Reasoning: Using a heap will ensure that the priority queue operations remain efficient even as the number of jobs grow. Insertion and removal are logarithmic due to the tree structure of the heap. Direct access to the highest-priority job is constant time because it's always at the root.
