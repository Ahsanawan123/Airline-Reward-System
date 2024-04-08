# Overview
  This Java-based program is designed to manage an airline loyalty system. It categorizes passengers into different tiers based on their flight activities, such as miles flown and the number of flights canceled. Each tier offers distinct benefits and privileges, incentivizing passengers to remain loyal to the airline and fly frequently.
  
# Class Descriptions
    Tier (Abstract Class): Serves as a blueprint for all tier classes, defining common attributes and methods that each tier must implement.
    NoTier: Default tier for new passengers or those with minimal flight activity.
    Gold: For passengers who have a certain threshold of miles or flight cancellations.
    Platinum, PlatinumPro, ExecutivePlatinum, SuperExecutivePlatinum: Higher tiers offering increased benefits, accessible by accumulating more miles or having a higher number of flight cancellations. PlatinumPro and above also require passengers not to have filed complaints to achieve the status.
    Passenger: Represents a traveler, tracking their miles, flights, and tier status.
    Main: The entry point of the program, orchestrating interactions and operations within the loyalty system.

# Tier Requirements
    NoTier: Default tier for new or inactive passengers.
    Gold: Achieved after a set number of cancellations.
    Platinum: Requires more miles or cancellations than Gold.
    PlatinumPro: Similar to Platinum but requires no complaints.
    ExecutivePlatinum: Higher thresholds of miles/cancellations.
    SuperExecutivePlatinum: Top tier, highest requirements, no complaints.

# Instructions to compile and run(for intelliJ Idea IDE)
1.) Install and Open intelliJ IDEA Community Edition: https://www.jetbrains.com/idea/
2.) Select "get from VCS" to open project
![image](https://github.com/Ahsanawan123/Airline-Reward-System/assets/98630461/4b8d2831-cf78-4325-878e-b059573b6e62)
3.) Copy the repository URL: https://github.com/Ahsanawan123/Airline-Reward-System.git 
    Paste it in "URL" 
    Select the directory that you want to save the clone of the project
    ![image](https://github.com/Ahsanawan123/Airline-Reward-System/assets/98630461/3482e01b-c76e-4d8c-9f49-339a90157241)
4.) Select clone and your project will either appear in the recent projects page or open automatically
5.) On the side bar, open project, go to main, and build and run the program
![image](https://github.com/Ahsanawan123/Airline-Reward-System/assets/98630461/8b2eb990-9f50-43e8-971a-17cbf2e11661)
