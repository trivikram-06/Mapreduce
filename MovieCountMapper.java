import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MovieCountMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
    private IntWritable movieId = new IntWritable();
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Split the line into fields
        String[] fields = value.toString().split("\t");

        // Extract movie ID (2nd field in zero-based index)
        int movie = Integer.parseInt(fields[1]);

        // Set movie ID as key
        movieId.set(movie);

        // Emit movie ID with count 1
        context.write(movieId, one);
    }
}

