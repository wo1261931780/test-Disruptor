package wo1261931780.testDisruptor.config;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wo1261931780.testDisruptor.factory.HelloEventFactory;
import wo1261931780.testDisruptor.model.MessageModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Intellij IDEA.
 * Project:test-Disruptor
 * Package:wo1261931780.testDisruptor
 *
 * @author liujiajun_junw
 * @Date 2023-10-11-07  星期五
 * @Description
 */
@Configuration
public class MQManager {
	/**
	 * 定义ringbuffer环形的缓冲区。
	 *
	 * 曾经 RingBuffer 是 Disruptor 中的最主要的对象，
	 *
	 * 但从3.0版本开始，其职责被简化为仅仅负责对通过 Disruptor 进行交换的数据（事件）进行存储和更新。
	 *
	 * 在一些更高级的应用场景中，Ring Buffer 可以由用户的自定义实现来完全替代。
	 *
	 * @return ringbuffer
	 */
	@Bean("messageModel")
	public RingBuffer<MessageModel> messageModelRingBuffer() {
		// 定义用于事件处理的线程池， Disruptor通过java.util.concurrent.ExecutorService提供的线程来触发consumer的事件处理
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// 指定事件工厂
		HelloEventFactory factory = new HelloEventFactory();

		// 指定ringbuffer字节大小，必须为2的N次方（能将求模运算转为位运算提高效率），否则将影响效率
		int bufferSize = 1024 * 256;

		// 单线程模式，获取额外的性能
		Disruptor<MessageModel> disruptor = new Disruptor<>(factory, bufferSize, executor,
				ProducerType.SINGLE, new BlockingWaitStrategy());

		// 设置事件业务处理器---消费者
		disruptor.handleEventsWith(new HelloEventHandler());

		// 启动disruptor线程
		disruptor.start();

		// 获取ringbuffer环，用于接取生产者生产的事件
		// RingBuffer<MessageModel> ringBuffer = disruptor.getRingBuffer();
		// 直接返回结果即可
		return disruptor.getRingBuffer();
	}
}
