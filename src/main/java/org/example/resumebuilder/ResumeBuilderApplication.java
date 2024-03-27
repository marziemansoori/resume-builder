package org.example.resumebuilder;

import org.example.resumebuilder.entities.Job;
import org.example.resumebuilder.entities.UserProfile;
import org.example.resumebuilder.repositories.JobRepository;
import org.example.resumebuilder.repositories.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class ResumeBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeBuilderApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner (
            UserProfileRepository userProfileRepository,
            JobRepository jobRepository
    ) {
        return args -> {
            Job job = Job.builder()
                    .designation("Software Engineer")
                    .startDate(LocalDate.of(2022, 1, 1))
                    .endDate(LocalDate.of(2024, 3, 1))
                    .company("Company A")
                    .build();

            jobRepository.save(job);

            Job job2 = Job.builder()
                    .designation("Software Engineer")
                    .startDate(LocalDate.of(2022, 1, 1))
                    .endDate(LocalDate.of(2024, 3, 1))
                    .company("Company A")
                    .build();

            jobRepository.save(job);

            Optional<UserProfile> profile = userProfileRepository.findByUserName("bill");
            profile.get().setJobs(Arrays.asList(job, job2));
        };
    }
}
