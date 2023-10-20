package wo1261931780.testDisruptor.service;

/**
 * Created by Intellij IDEA.
 * Project:test-Disruptor
 * Package:wo1261931780.testDisruptor.service
 *
 * @author liujiajun_junw
 * @Date 2023-10-11-08  星期五
 * @Description
 */
public interface DisruptorMqService {
	/**
	 * 项目内部使用Disruptor做消息队列
	 * @param message 消息内容
	 */
	void sayHelloMq(String message);
}
