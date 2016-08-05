# Class Code Generator
The Class Code Generator (CCG) is an application that can automate [some] work for developers of all kinds.  The application is written in Java (version 1.8) to be used for (primarily) Java developers.

_**Current Version = Alpha v. 1.0**_

## Languages Written For:
* (Alpha version 1.0) - Java  
* (Alpha version 1.1) - Java, C#, Python (3.x)  
* (Alpha version 1.2) - Java, C#, Python (3.x), C++  
* (Alpha version 1.3) - Java, C#, Python (3.x), C++, C

### GUI Planned Features
1.1 = build C# classes (non-partial) + C# interfaces, and Python (3.x) classes  
1.2 = build C++ classes, and C++ abstract (pure virtual methods [=0])  
1.3 = build C structs

### Command Line Planned Features
1.4 = build C# classes (partials included) + C# interfaces, and Python (3.x) classes  
1.5 = build C structs  
1.6 = build C++ classes, and C++ abstract (pure virtual methods [=0])

#
## Command Line
The command line component of the applicaiton is the primary point of file and project management.  It also works (hand-in-hand) with the GUI as they both can take simlilar input, but the command line can manage more, better.  Valid commands and statements can also be written into a script and saved as a text file, then loaded into the command line to be parsed and executed (note: scripts will always inform the user with a confirmation message, whether or not the user has the 'confirm' command enabled).

#
## GUI
The GUI for the CCG application is designed for basic class specs as required per individual, or the requirements for a project.  In addition, the GUI can load any data into an XML document, or will unpack an XML document into the form elements on the GUI.  This means that the GUI can only handle one file manipulation at a time, whereas the command line component can take/handle multiple files.  Keep in mind that the GUI may load/unload any XML document with project data/information, but will only be designed for single-file management & manipulation.

### Other Details
**Author Name**:  Travis Mitchum  
**Date of Authoring**:  August 3, 2016  
**Last Update On**:  Aug. 5, 2016  
_**(author contact info may be obtained through message via their profile)**_
