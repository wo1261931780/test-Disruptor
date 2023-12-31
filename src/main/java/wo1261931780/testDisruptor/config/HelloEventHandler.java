package wo1261931780.testDisruptor.config;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;
import wo1261931780.testDisruptor.model.MessageModel;

/**
 * Created by Intellij IDEA.
 * Project:test-Disruptor
 * Package:wo1261931780.testDisruptor.config
 *
 * @author liujiajun_junw
 * @Date 2023-10-11-06  星期五
 * @Description
 */
@Slf4j
public class HelloEventHandler implements EventHandler<MessageModel> {
	/**
	 * 消费者处理消息
	 * @param event 消息对象
	 * @param sequence 序号
	 * @param endOfBatch 是否是最后一个元素
	 */
	@Override
	public void onEvent(MessageModel event, long sequence, boolean endOfBatch) {
		try {
			//这里停止1000ms是为了确定消费消息是异步的
			Thread.sleep(1000);
			log.info("消费者处理消息开始");
			if (event != null) {
				log.info("消费者消费的信息是：{}",event);
			}
		} catch (Exception e) {
			log.info("消费者处理消息失败");
		}
		log.info("消费者处理消息结束");
	}
}
