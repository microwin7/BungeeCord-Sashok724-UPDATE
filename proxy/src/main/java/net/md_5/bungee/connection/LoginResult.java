package net.md_5.bungee.connection;

import com.mojang.authlib.yggdrasil.CompatProfile;
import java.util.Arrays;
import lombok.Data;

@Data
public class LoginResult
{
    private String id;
    private String name;
    private LoginResult.Property[] properties;

    public LoginResult(CompatProfile profile)
    {
        this.id = profile.uuidHash;
        this.properties = new LoginResult.Property[profile.countProperties()];
        int index = 0;
        if ( profile.skinURL != null )
        {
            this.properties[index++] = new LoginResult.Property( "skinURL", profile.skinURL, "" );
        }

        if ( profile.skinDigest != null )
        {
            this.properties[index++] = new LoginResult.Property( "skinDigest", profile.skinDigest, "" );
        }

        if ( profile.cloakURL != null )
        {
            this.properties[index++] = new LoginResult.Property( "cloakURL", profile.cloakURL, "" );
        }

        if ( profile.cloakDigest != null )
        {
            this.properties[index++] = new LoginResult.Property( "cloakDigest", profile.cloakDigest, "" );
        }

    }

    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public LoginResult.Property[] getProperties()
    {
        return this.properties;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setProperties(LoginResult.Property[] properties)
    {
        this.properties = properties;
    }

    public boolean equals(Object o)
    {
        if ( o == this )
        {
            return true;
        } else if ( !( o instanceof LoginResult ) )
        {
            return false;
        } else
        {
            LoginResult other = (LoginResult) o;
            if ( !other.canEqual( this ) )
            {
                return false;
            } else
            {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if ( this$id == null )
                {
                    if ( other$id != null )
                    {
                        return false;
                    }
                } else if ( !this$id.equals( other$id ) )
                {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if ( this$name == null )
                {
                    if ( other$name != null )
                        return false;
                } else if ( !this$name.equals( other$name ) )
                {
                    return false;
                }

                if ( !Arrays.deepEquals( this.getProperties(), other.getProperties() ) )
                {
                    return false;
                } else
                {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other)
    {
        return other instanceof LoginResult;
    }

    public int hashCode()
    {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ( $id == null ? 43 : $id.hashCode() );
        Object $name = this.getName();
        result = result * 59 + ( $name == null ? 43 : $name.hashCode() );
        result = result * 59 + Arrays.deepHashCode( this.getProperties() );
        return result;
    }

    public String toString()
    {
        return "LoginResult(id=" + this.getId() + ", name=" + this.getName() + ", properties=" + Arrays.deepToString( this.getProperties() ) + ")";
    }

    public LoginResult(String id, String name, LoginResult.Property[] properties)
    {
        this.id = id;
        this.name = name;
        this.properties = properties;
    }

    @Data
    public static class Property
    {
        private String name;
        private String value;
        private String signature;

        public String getName()
        {
            return this.name;
        }

        public String getValue()
        {
            return this.value;
        }

        public String getSignature()
        {
            return this.signature;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

        public void setSignature(String signature)
        {
            this.signature = signature;
        }

        public boolean equals(Object o)
        {
            if ( o == this )
            {
                return true;
            } else if ( !( o instanceof LoginResult.Property ) )
            {
                return false;
            } else
            {
                LoginResult.Property other = (LoginResult.Property) o;
                if ( !other.canEqual( this ) )
                {
                    return false;
                } else
                {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if ( this$name == null )
                    {
                        if ( other$name != null )
                        {
                            return false;
                        }
                    } else if ( !this$name.equals( other$name ) )
                    {
                        return false;
                    }

                    Object this$value = this.getValue();
                    Object other$value = other.getValue();
                    if ( this$value == null )
                    {
                        if ( other$value != null )
                        {
                            return false;
                        }
                    } else if ( !this$value.equals( other$value ) )
                    {
                        return false;
                    }

                    Object this$signature = this.getSignature();
                    Object other$signature = other.getSignature();
                    if ( this$signature == null )
                    {
                        if ( other$signature != null )
                        {
                            return false;
                        }
                    } else if ( !this$signature.equals( other$signature ) )
                    {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(Object other)
        {
            return other instanceof LoginResult.Property;
        }

        public int hashCode()
        {
            int PRIME = 59;
            int result = 1;
            Object $name = this.getName();
            result = result * 59 + ( $name == null ? 43 : $name.hashCode() );
            Object $value = this.getValue();
            result = result * 59 + ( $value == null ? 43 : $value.hashCode() );
            Object $signature = this.getSignature();
            result = result * 59 + ( $signature == null ? 43 : $signature.hashCode() );
            return result;
        }

        public String toString()
        {
            return "LoginResult.Property(name=" + this.getName() + ", value=" + this.getValue() + ", signature=" + this.getSignature() + ")";
        }

        public Property(String name, String value, String signature)
        {
            this.name = name;
            this.value = value;
            this.signature = signature;
        }
    }
}
