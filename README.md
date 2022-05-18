# Data-Deduplication-UsingDifferentFileTypes
Data Deduplication a specialized data compression technique for eliminating duplicate copies of repeating data. The need of data duplication is to clean the sources to remove the redundant datas which unnecessary take more space.
This technique is used to improve storage utilization and can be applied to network data transfers to reduce the number of bytes and also can be used for security reason.

With this Deduplication, only one instance of the attachment is actually stored. This is mainly used to solve the problem of space. This technique effectively reduces storage capacity requirements & has applications whenever multiple copies of same data set are needed to be stored.

There are numerous techniques for reducing data duplication on different types of file systems like **text files, image files ,audio files, video files etc.**
In this project we will **only focus on Text file system**. this project will be able to do both **Encryption** and **Decyption** (It works on **Binary Encoding Techquenie**). It has a limitation, **if the colon (:) is present in the original file then it will automaticallydeleted.**

### DEDUPLICATION Vs COMPRESSION 
Deduplication eliminates redundant data while compression uses algorithms to save data more concisely.
Some compression is lossless, meaning that no data is lost in the process, but "lossy" compression, which is frequently used with audio and video files, actually deletes some of the less-important data included in a file in order to save space. By contrast, deduplication only eliminates extra copies of data, but none of the original data is lost.

Deduplication often has a larger impact on backup file size than compression. In a typical enterprise backup situation, compression may reduce backup size by a ratio of 2:1 or 3:1, while deduplication can reduce backup size by up to 25:1, depending on how much duplicate data is in the systems. Often enterprises utilize Deduplication and compression together in order to maximize their savings.
