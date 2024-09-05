# MovieLens MapReduce Project

## Overview

This project involves using Hadoop MapReduce to analyze the MovieLens 100K dataset, specifically to compute the average movie ratings. The project demonstrates the application of MapReduce for distributed data processing.

## Process Overview

- **Dataset Acquisition**:
  - **Source**: The dataset used is the MovieLens 100K dataset, which contains user ratings for movies.
  - **File Utilized**: `u.data`, which includes ratings data with fields for user ID, movie ID, rating, and timestamp.

- **Environment Setup**:
  - **Requirements**: Java, Hadoop, and Git must be installed and configured on your system. Hadoop should be set up to run in pseudo-distributed mode.

- **Project Directory Creation**:
  - **Action**: Create a dedicated directory to store project files such as Java source code, compiled classes, and results.

- **MapReduce Implementation**:
  - **Mapper**: Reads each record from the dataset, emitting the movie ID as the key and the rating as the value.
  - **Reducer**: Aggregates the ratings by movie ID and calculates the average rating for each movie.

- **Compilation and Packaging**:
  - **Action**: Compile the Java code and package it into a JAR file. This JAR file contains the compiled MapReduce program that will be executed on Hadoop.

- **Data Upload to HDFS**:
  - **Action**: Upload the `u.data` file to the Hadoop Distributed File System (HDFS) to prepare it for processing by the MapReduce job.

- **Executing the MapReduce Job**:
  - **Action**: Run the MapReduce job using the JAR file, specifying the input data path in HDFS and defining an output directory to store the results.

- **Viewing the Output**:
  - **Action**: Access and review the output stored in HDFS, which provides the average ratings for each movie.

- **Version Control and GitHub Integration**:
  - **Action**: Initialize a Git repository within the project directory, commit all relevant files including the source code and results, and push the changes to a GitHub repository.
  - **Authentication**: Use a personal access token for secure authentication with GitHub, as password authentication has been deprecated.

## Dataset Details

- **`u.data`**: This file contains user ratings in the format of user ID, movie ID, rating, and timestamp. It is the primary data source used for calculating average movie ratings.

## Conclusion

This project showcases the use of Hadoop MapReduce for large-scale data processing, specifically in the context of analyzing movie ratings. By following this process, you can compute aggregate metrics like average ratings efficiently using distributed computing.
