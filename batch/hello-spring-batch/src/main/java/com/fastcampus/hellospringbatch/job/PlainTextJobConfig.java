package com.fastcampus.hellospringbatch.job;

import com.fastcampus.hellospringbatch.core.domain.PlainText;
import com.fastcampus.hellospringbatch.core.domain.ResultText;
import com.fastcampus.hellospringbatch.core.repository.PlainTextRepository;
import com.fastcampus.hellospringbatch.core.repository.ResultTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.*;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class PlainTextJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final PlainTextRepository plainTextRepository;
    private final ResultTextRepository resultTextRepository;

    @Bean("plainTextJob")
    public Job plainTextJob(Step plainTextStep) {
        return jobBuilderFactory.get("plainTextJob")
                .incrementer(new RunIdIncrementer())
                .start(plainTextStep)
                .build();
    }

    @JobScope
    @Bean("plainTextStep")
    public Step plainTextStep(ItemReader plainTextReader,
                          ItemProcessor plainTextProcessor,
                          ItemWriter plainTextWriter) {
        return stepBuilderFactory.get("helloStep")
                .<PlainText, String>chunk(5) // <읽어올 타입, 프로세싱 타입> chunk사이즈는 pageSize와 같이 5개
                .reader(plainTextReader)
                .processor(plainTextProcessor)
                .writer(plainTextWriter)
                .build();
    }

    // chunk 기반
    @StepScope
    @Bean
    public RepositoryItemReader<PlainText> plainTextReader() {
        return new RepositoryItemReaderBuilder<PlainText>()
                .name("plainTextReader")            // 이름 작성
                .repository(plainTextRepository)    // 어떤 repository ?
                .methodName("findBy")               // repository에서 선언한 어떤 method를 통해서 ?
                .pageSize(5)                        // 페이지 5개씩
                .arguments(List.of())               // 리스트로 반환하는데 지금은 빈 리스트 반환
                .sorts(Collections.singletonMap("id", Sort.Direction.DESC)) // 리스트 정렬 : desc
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<PlainText, String> plainTextProcessor() { // ItemProcessor<프로세싱 하기 전 타입, 프로세싱 할 타입>
//        return new ItemProcessor<PlainText, String>() {
//            @Override
//            public String process(PlainText item) throws Exception {
//                return null;
//            }
//        } 람다식으로 대처 가능
        return item -> "processed " + item.getText();
    }

    @StepScope
    @Bean
    public ItemWriter<String> plainTextWriter() {
//        return new ItemWriter<String>() {
//            @Override
//            public void write(List<? extends String> items) throws Exception {
//
//            }
//        } 람다식으로 대처 가능
        return items -> {
//            items.forEach(System.out::println);
            items.forEach(item -> resultTextRepository.save(new ResultText(null, item)));
            System.out.println("==== chunk is finished");
        };
    }

}
