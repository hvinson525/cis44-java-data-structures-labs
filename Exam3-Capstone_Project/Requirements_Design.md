# Capstone Project - Job Scheduler Design Document

## Problem Analysis
I need to create a system to schedule jobs based on priority. Jobs with a higher priority should be executed first.

## Choice of Data Structure
I will use a priority queue implemented with a max-heap and assign more important jobs a higher number.

## Original UML Diagram
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

## Phase 2 UML Diagram
+-------------------------+
|        Job              |
+-------------------------+
| - id: int               |
| - priority: int         |
| - description: String   |
+-------------------------+
| + Job(id:int, priority:int, description:String) |
| + getID(): int          |
| + getPriority(): int    |
| + getDescription(): String |
| + compareTo(other: Job): int |
| + toString(): String    |
+-------------------------+

           ^
           |
           |
+-------------------------+
|       JobHeap           |
+-------------------------+
| - heap: ArrayList<Job>  |
+-------------------------+
| + JobHeap()             |
| + insert(job: Job): void|
| + extractMax(): Job     |
| + peek(): Job           |
| + downHeap(index: int): void |
| + upHeap(index: int): void   |
| + swap(i: int, j: int): void |
| + isEmpty(): boolean    |
| + size(): int           |
+-------------------------+

           ^
           |
           |
+-------------------------+
|     SchedulerTest       |
+-------------------------+
| (main method only)      |
+-------------------------+

## Phase 3 UML Design
+--------------------------------------------------+
|                     Job                          |
+--------------------------------------------------+
| - id: int                                        |
| - priority: int                                  |
| - description: String                            |
+--------------------------------------------------+
| + Job(id: int, priority: int, description: String) |
| + getId(): int                                   |
| + getPriority(): int                             |
| + setPriority(priority: int): void               |
| + getDescription(): String                       |
| + compareTo(other: Job): int                     |
| + toString(): String                             |
+--------------------------------------------------+
| <<implements Comparable<Job>>                    |
+--------------------------------------------------+


                     1       * 
Job ------------------------------------> JobHeap
      (stored in ArrayList<Job>)


+--------------------------------------------------+
|                    JobHeap                       |
+--------------------------------------------------+
| - heap: ArrayList<Job>                           |
+--------------------------------------------------+
| + JobHeap()                                      |
| + insert(job: Job): void                         |
| + extractMax(): Job                              |
| + peek(): Job                                    |
| + updatePriority(jobId: int, newPriority: int): boolean |
| + removeJob(jobId: int): boolean                 |
| + isEmpty(): boolean                             |
| + size(): int                                    |
|                                                  |
| - findIndexById(jobId: int): int                 |
| - upHeap(index: int): void                       |
| - downHeap(index: int): void                     |
| - swap(i: int, j: int): void                     |
+--------------------------------------------------+


                     uses
SchedulerTest ------------------> JobHeap
SchedulerTest ------------------> Job


+--------------------------------------------------+
|                SchedulerTest                     |
+--------------------------------------------------+
| + main(args: String[]): void                     |
+--------------------------------------------------+
| <<console UI / program entry>>                   |
+--------------------------------------------------+

##Phase 4 UML Design
+------------------------------------------------------+
|                        Job                           |
+------------------------------------------------------+
| - id: int                                             |
| - description: String                                 |
| - priority: int                                       |
+------------------------------------------------------+
| + Job(id: int, description: String, priority: int)    |
| + getId(): int                                        |
| + getDescription(): String                            |
| + getPriority(): int                                  |
| + setPriority(priority: int): void                    |
| + compareTo(other: Job): int                          |
| + toString(): String                                  |
+------------------------------------------------------+
                           ▲
                           |
                           |  Uses Job objects
                           |
+------------------------------------------------------+
|                      JobHeap                          |
+------------------------------------------------------+
| - heap: ArrayList<Job>                                |
+------------------------------------------------------+
| + JobHeap()                                            |
| + insert(job: Job): void                               |
| + removeMax(): Job                                     |
| + peek(): Job                                          |
| + isEmpty(): boolean                                   |
| + getSize(): int                                       |
| - heapifyUp(i: int): void                              |
| - heapifyDown(i: int): void                            |
| - swap(i: int, j: int): void                           |
+------------------------------------------------------+
                           ▲
                           |
                           |  Uses JobHeap to test logic
                           |
+------------------------------------------------------+
|                 MainTestDriver                        |
+------------------------------------------------------+
| <<Utility class for Phase 4 testing>>                 |
+------------------------------------------------------+
| + main(args: String[]): void                          |
| + testInsert(): void                                  |
| + testRemoveMax(): void                               |
| + testPeek(): void                                    |
| + testEmptyHeap(): void                               |
| + testOrder(): void                                   |
| + testDuplicatePriorities(): void                     |
| + printResult(name: String, passed: boolean): void    |
+------------------------------------------------------+
