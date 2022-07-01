package com.kaltura.playkit.plugins.youbora.pluginconfig;

class User {
   private String anonymousId;
   private String type;
   private String email;
   private boolean obfuscateIp;

   public String getAnonymousId() {
      return anonymousId;
   }

   public void setAnonymousId(String anonymousId) {
      this.anonymousId = anonymousId;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public boolean getObfuscateIp() {
      return obfuscateIp;
   }

   public void setObfuscateIp(boolean obfuscateIp) {
      this.obfuscateIp = obfuscateIp;
   }
}
