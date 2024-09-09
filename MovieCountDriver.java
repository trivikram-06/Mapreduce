import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MovieCountDriver {
    public static void main(String[] args) throws Exception {
        // Create a new job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Movie Ratings Count");

        // Set driver, mapper, and reducer classes
        job.setJarByClass(MovieCountDriver.class);
        job.setMapperClass(MovieCountMapper.class);
        job.setReducerClass(MovieCountReducer.class);

        // Set output key and value classes
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);

        // Set input and output paths
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // Exit the job when finished
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

