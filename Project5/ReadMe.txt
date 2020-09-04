//JuneYeob Lee
//2462 9603
//CS471

ReadMe(Project5)

1. File list
----------------
Blocking.java 		Blocking class to calculate completion time with Flow Shop Scheduling with blocking
CreateCSV.java		CreateCSV class to create CSV file with makespans
FileRead.java		File read class to read data file.
FlowShop.java		FlowShop class to calculate completion time with Flow Shop Scheduling 
Main.java	 	Main class
NEH.java		NEH class to implement NEH algorithm with 4 steps
Nowait.java		Nowait class to calculate completion time with Flow Shop Scheduling with No-Wait

2. Purpose
----------------
Project 5 is to solve the three different scheduling problems of Flowshop(FSS), Flowshop with blocking(FSSB), and Flowshop with no-wait(FSSNW).
Through the NEH heuristic algorithm with FSS, FSSB, and FSSNW findout the shortest makespan as possible. 

3.BenchMark 
-----------------------------------
Processor: Intel(R) Core(TM) i5-7200CPU @ 2.50GHz (4 CPUs),~ 2.7GHz
Memory: 8192 MB RAM
GPU : NVIDIA GeForce 940Mx

4.Build project with different IDE
-----------------------------------
Intellij user
4-1. Go to File--New--Project from existing Source.
4-2. Select NetBeans Project Directory
4-3. Import Project Wizard open. Select Create Project from Existing Sources
4-4  Follow on-screen instruction to continue

5. Run
---------------------
1. Type Data file number (1~120).
2. Select Algorithm to get makespan.(Flowshop =F, flowshop with blocking = B, and flowshop with no-wait =N).
					
6. Output
-----------------
Output will show you sequence of jobs, makespan, and execution time of user select File.


7. Notice
_______________________
Make sure that you have Data Files(1~120) in working directory.
