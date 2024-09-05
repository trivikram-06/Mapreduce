import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MovieRatingsMapper extends Mapper<Object, Text, IntWritable, IntWritable> {
    private IntWritable movieId = new IntWritable();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] parts = value.toString().split("\t");
        if (parts.length == 4) {
            int movieId = Integer.parseInt(parts[1]);
            int rating = Integer.parseInt(parts[2]);
            context.write(new IntWritable(movieId), new IntWritable(rating));
        }
    }
}
