**Final IHK Project (aicas 2021) - "Creation and controlling of a graphical interface through speech recognition"**
===============================================================================================================

**File structure of this repository:**
======================================
 
        - README.md (contains all the necessary information about the project)
        - voiceRecognition-main (main project folder) >
                                                                    - Documentation (Official documentation of the process)
                                                                    - Images_Doc (Supporting images, infographics, screenshots and diagrams)
                                                                    - Libraries (Libraries used by the application)
                                                                    - PA_GUI_VoiceRecognition (Maven JavaFX Project folder)
                                                                    - Resources (Linguistic and grammatical resources)


**Project general description**:
============

This project consists of integrating a graphical interface to a voice recognition system pre-configured with CMUSphinx using JavaFX.

**Goals**:
======

- Create a functional graphical interface with JavaFX and adapt it to the current functionalities of the speech recognition system created in Java using CMUSphinx libraries in order to increase productivity and provide greater control to the developer through the use of specific voice instructions.
- Integrate Thread into development to facilitate the synchronization of the various multiprocesses associated with the control of the interface

**To-Do**:
=====

- Prepare the development environment: IDE, Java Project, Repository, CMU Libraries, JavaFX path, etc
- Demonstrate the use of the 4 basic functions of the CMUSphinx Library: Transcriber, SpeakerID, Assitant and Aligner
- Create a graphical interface with JavaFX
- Integrate the graphical interface in the previously configured demos with Java
- Control the created graphical interface through buttons and voice commands
- Document development processes, limitations and current issues

**Prerequisites and Dependencies**:
===============================

**CMUSphinx**
=========
    
- **Repository**: https://github.com/aicas-martin/voiceRecognition.git
- **Tutorial**: https://cmusphinx.github.io/wiki/tutorial/
- **External Libraries**: https://oss.sonatype.org/#nexus-search;quick~sphinx
- **TranscriberDemo**: https://github.com/cmusphinx/sphinx4/blob/master/sphinx4-samples/src/main/java/edu/cmu/sphinx/demo/transcriber/TranscriberDemo.java
- **AlignerDemo**: https://github.com/cmusphinx/sphinx4/blob/master/sphinx4-samples/src/main/java/edu/cmu/sphinx/demo/aligner/AlignerDemo.java
- **DialogDemo**: https://github.com/cmusphinx/sphinx4/blob/master/sphinx4-samples/src/main/java/edu/cmu/sphinx/demo/dialog/DialogDemo.java
- **SpeakerID**: https://github.com/cmusphinx/sphinx4/blob/master/sphinx4-samples/src/main/java/edu/cmu/sphinx/demo/speakerid/SpeakerIdentificationDemo.java
- **Microphone Support on target platform**
- **Javax.sound API support**

**JavaFX**
======

**- Java Runtime Environment (JRE 1.8)**

**JIRA Page of this Project**
==========================

https://jira.aicas.de/browse/ICDA-16


**Application structure**:
======================


                Initial Menu 
                            - Demos button > Demos Menu    
                                                    - Transcriber button > Transcriber Menu
                                                                                           - Transcriber Demo (the audio-to-text transcription process begins: Supports real-time voice input and .wav audio files)
                                                                                           - Back (back to Demos Menu)
                                                    - Assitant button > Assitant
                                                                                - Assitant Demo (the voice assistant process starts: Specific programs can be opened or closed using voice commands)
                                                                                - Back (back to Demos Menu)  
                                                    - SpeakerID button > SpeakerID
                                                                                  - SpeakerID Demo (used to identify how many people speak at the same time in a specific audio file)
                                                                                  - Back (back to Demos Menu)

                                                    - Aligner button > Aligner
                                                                              - Aligner Demo (It is used to calibrate the speech recognition process. The improvement will depend on the quality of the audio and the ambient noise)
                                                                              - Back (back to Demos Menu)
                                                    - Back button > Back to Initial Menu


**Project voice commands**:
========================

You can control the graphical interface by pressing the corresponding buttons or by using the following voice commands:

- wake up
- sleep
- exit
- back
- speak
- change
- maximize
- minimize
- next
- transcriber
- assistant
- speaker
- aligner
- rec
- open
- play
- open browser
- close browser
- open thunderbird
- close thunderbird
- open terminal
- close terminal
- open teams
- close teams
- up
- down 
- left
- right
- top
- press
- touch
- 0
- 1
- 2...


**Instructions for use**:
======================

**1. Clone the gitlab repository**
 
    $ git clone https://github.com/aicas-martin/voiceRecognition.git

    $ cd voiceRecognition-main


**2. Import the Maven Project**

- From the IDE select the option to "import existing maven project" (locate the path where is the file pom.xml)

**Note: In this case the PATH is:** /Voice_recognition-with-GUI-IHK_project/PA_GUI_VoiceRecognition


**3. Run the GUI Demo from IDE**

- Within the maven project, go to the following path: src/main/java and find the folder "concurrent_task_service"

- Then run the class Main.java

**Note: If there is a problem with the execution of a particular class, it may be due to the configuration of the libraries, to solve it, go to the build_path section, then find and select the libraries and the corresponding paths.**


**4. Application Operation**

- Execute the Main.java class: When the program is executed, the graphical interface corresponding to the initial menu will appear with the "Demos" button. The voice recognition process will be activated immediately, will also run in background in an interrupted way as second process.

- Press the **Demos** button or use the voice command "Wake-UP": We can go to the menu corresponding to the demos of this application where 5 buttons will appear
    
    - Transcriber button
    - Assitant button
    - SpeakerID button
    - Aligner button
    - Back button

**Note: Each button corresponds to a different sub-menu where you can run the specific demo or you can simply return to the previous menu by pressing the corresponding buttons or simply, through voice commands, invoking the name of the buttons that you want to press. The functions of each button are explained higher in the structure of the application.**

- To exit the application, you can simply close the entire process, pressing the exit button located in the upper right corner of the interface, or simply using the "Exit" voice command.


