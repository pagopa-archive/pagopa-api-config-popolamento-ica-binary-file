package it.gov.pagopa.project;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateIca {
    /**
     * This function is called by a cron function
     */
    @FunctionName("UpdateIca")
    public void run (
            @TimerTrigger(name = "cronTrigger", schedule = "*/2 * * * *") String timerInfo,
            final ExecutionContext context) {

        String lastExecuted = new JSONObject(timerInfo)
                .getJSONObject("ScheduleStatus")
                .getString("Last");
        context.getLogger().info("Timer was triggered last time at: " + lastExecuted);
    }
}
