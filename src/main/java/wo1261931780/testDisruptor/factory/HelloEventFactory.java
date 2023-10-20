package wo1261931780.testDisruptor.factory;

import com.lmax.disruptor.EventFactory;
import wo1261931780.testDisruptor.model.MessageModel;

/**
 * Created by Intellij IDEA.
 * Project:test-Disruptor
 * Package:wo1261931780.testDisruptor.factory
 *
 * @author liujiajun_junw
 * @Date 2023-10-11-05  星期五
 * @Description
 */
public class HelloEventFactory implements EventFactory<MessageModel> {
	@Override
	public MessageModel newInstance() {
		return new MessageModel();
	}
}
