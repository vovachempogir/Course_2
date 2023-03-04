package Task;

public enum Repeatability {
    SINGLE {
        public Task createTask() {
            return new SingleTask();
        }
    },
    DAILY {
        public Task createTask() {
            return new DailyTask();
        }
    },
    WEEKLY {
        public Task createTask() {
            return new WeeklyTask();
        }
    },
    MONTHLY {
        public Task createTask() {
            return new MonthlyTask();
        }
    },
    YEARLY {
        public Task createTask() {
            return new YearlyTask();
        }
    };

    private Repeatability() {
    }

    public abstract Task createTask();
}
