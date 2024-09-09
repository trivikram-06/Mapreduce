import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MovieCountReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
    private IntWritable result = new IntWritable();

    @Override
    protected void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        // Sum all the counts for a movie ID
        for (IntWritable val : values) {
            sum += val.get();
        }

        // Set the sum as the result
        result.set(sum);

        // Emit the movie ID and its total count
        context.write(key, result);
    }
}

