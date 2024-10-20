package com.samas.pedestriantest;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class SettingsActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "channel_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);

            SwitchPreferenceCompat notificationsSwitch = findPreference("notifications");
            if (notificationsSwitch != null) {
                notificationsSwitch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object newValue) {
                        boolean isEnabled = (Boolean) newValue;
                        if (isEnabled) {
                            Toast.makeText(getContext(), "Notifications Enabled", Toast.LENGTH_SHORT).show();
                            enableNotifications();
                        } else {
                            Toast.makeText(getContext(), "Notifications Disabled", Toast.LENGTH_SHORT).show();
                            disableNotifications();
                        }
                        return true;
                    }
                });
            }
        }

        private void enableNotifications() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationChannel channel = new NotificationChannel(
                        CHANNEL_ID,
                        "nChannel",
                        NotificationManager.IMPORTANCE_DEFAULT
                );
                channel.setDescription("Messages");
                notificationManager.createNotificationChannel(channel);
            }
        }

        private void disableNotifications() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.deleteNotificationChannel(CHANNEL_ID);
            }
        }
    }
}